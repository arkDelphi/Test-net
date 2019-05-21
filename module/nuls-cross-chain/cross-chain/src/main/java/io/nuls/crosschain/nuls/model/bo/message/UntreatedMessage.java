package io.nuls.crosschain.nuls.model.bo.message;
import io.nuls.base.data.NulsDigestData;
import io.nuls.crosschain.base.message.base.BaseMessage;

public class UntreatedMessage {
    private int chainId;
    private String nodeId;
    private BaseMessage message;
    private NulsDigestData cacheHash;

    public int getChainId() {
        return chainId;
    }

    public void setChainId(int chainId) {
        this.chainId = chainId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public BaseMessage getMessage() {
        return message;
    }

    public void setMessage(BaseMessage message) {
        this.message = message;
    }

    public NulsDigestData getCacheHash() {
        return cacheHash;
    }

    public void setCacheHash(NulsDigestData cacheHash) {
        this.cacheHash = cacheHash;
    }
}
