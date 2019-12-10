package io.nuls.api.task;


import io.nuls.api.ApiContext;
import io.nuls.api.analysis.WalletRpcHandler;
import io.nuls.api.cache.ApiCache;
import io.nuls.api.manager.CacheManager;
import io.nuls.api.model.po.AssetInfo;
import io.nuls.api.model.po.ChainInfo;
import io.nuls.api.utils.LoggerUtil;
import io.nuls.core.basic.Result;

import java.util.HashMap;
import java.util.Map;

public class QueryChainInfoTask implements Runnable {

    private int chainId;

    public QueryChainInfoTask(int chainId) {
        this.chainId = chainId;
    }

    @Override
    public void run() {
        try {
            Map<Integer, ChainInfo> chainInfoMap = new HashMap<>();
            Map<String, AssetInfo> assetInfoMap = new HashMap<>();
            //添加本链默认链信息和资产信息
            ApiCache apiCache = CacheManager.getCache(chainId);
            ChainInfo chainInfo = apiCache.getChainInfo();
            chainInfoMap.put(chainInfo.getChainId(), chainInfo);
            assetInfoMap.put(chainInfo.getDefaultAsset().getKey(), chainInfo.getDefaultAsset());


            //如果是跨链 ，还需要添加跨链资产
            if (ApiContext.isRunCrossChain) {
                Result<Map<String, Object>> result = WalletRpcHandler.getRegisteredChainInfoList();
                Map<String, Object> map = result.getData();
                Map<Integer, ChainInfo> chainInfoMap1 = (Map<Integer, ChainInfo>) map.get("chainInfoMap");
                for (ChainInfo chainInfo1 : chainInfoMap1.values()) {
                    if (!chainInfoMap.containsKey(chainInfo1.getChainId())) {
                        chainInfoMap.put(chainInfo1.getChainId(), chainInfo1);
                    }
                }

                Map<String, AssetInfo> assetInfoMap1 = (Map<String, AssetInfo>) map.get("assetInfoMap");
                for (AssetInfo assetInfo : assetInfoMap1.values()) {
                    if (!assetInfoMap.containsKey(assetInfo.getKey())) {
                        assetInfoMap.put(assetInfo.getKey(), assetInfo);
                    }
                }
                CacheManager.setChainInfoMap(chainInfoMap);
                CacheManager.setAssetInfoMap(assetInfoMap);
                ApiContext.isReady = true;
            } else {
                CacheManager.setChainInfoMap(chainInfoMap);
                CacheManager.setAssetInfoMap(assetInfoMap);
                ApiContext.isReady = true;
            }

        } catch (Exception e) {
            LoggerUtil.commonLog.error(e);
        }
    }
}
