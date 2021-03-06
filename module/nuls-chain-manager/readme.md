# 链管理模块

## 为什么要有《链管理》模块

在NULS 1.0中，只有一条链（NULS主网），因此不需要链管理模块。

在NULS 2.0中，NULS主网上可以注册其他友链信息，包括:        

- NULS生态圈中的链：与NULS主网使用同一套代码衍生出来。
- 其他链：比特币、以太坊等

《链管理》模块用来管理所有加入NULS主网的友链的信息

名词解释：

- NULS主网：不同于NULS 1.0，是独立运行的另一条链，也称之为NULS 2.0。
  《链管理》是NULS主网的其中一个模块
- 友链：在NULS主网上注册的其他链

假设1：友链A，其拥有资产A

假设2：友链B，其拥有资产B

- 跨链交易：
  - 友链A把资产A转到友链B
  - 友链B内部转移资产A
  - 友链B把资产A转回到友链A
  - 友链B把资产A转到其他友链（C,D等）
- 非跨链交易：
  - 友链A内部转移资产A
  - 友链B内部转移资产B

备注：不论链内资产，还是链外资产，只要资产跨链进行交易，就需要主网进行确认。

## 《链管理》要做什么

《链管理》模块用来管理加入NULS主网的链的基本信息，包括：

* 注册一条新的友链
* 销毁已经存在的友链
* 查询友链信息
* 特定友链增加资产类型
* 特定友链销毁资产类型
* 跨链资产校验

## 《链管理》在系统中的定位

《链管理》强依赖的模块：

- 核心模块
- 网络模块
- 交易管理模块
- 账本模块

《链管理》弱依赖的模块：

- 事件总线模块


