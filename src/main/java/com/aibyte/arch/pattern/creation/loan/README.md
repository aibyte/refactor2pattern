#  “银行业的一个贷款风险估算程序”

## 背景及需求

Loan可以用来表示7种贷款方式。这里只讨论其中的3种。  
* 定期贷款（term loan），是指在到期日必须偿还的借款。  
* 循环贷款（revolver）类似于信用卡，是一种标明“循环信用”的贷款形式，具有贷款额度（spending limit）和有效期（expiry date）。  
* 循环信用定期贷款（revolving credit term loan，RCTL）是一种满期后可以转换为定期贷款的循环贷款。

### 设计的考量

* 为什么不将Loan设计成一个抽象超类，用子类表示各种贷款呢？

(1)区分不同种类贷款的并不是它们的字段，而是计算资金（capital）、收益（income）和期限（duration）等数值的方式。我们可不想仅仅为了要支持计算定期贷款资金的 3 种方式就创建Loan的3个不同子类。很容易做到的是，只支持一个Loan类，为定期贷款设3个不同的Strategy类。
(2)使用Loan实例的应用需要在不同种类的贷款之间进行转换。这种转换如果只需要修改一个Loan实例的几个字段，要比在Loan的不同子类的实例之间转换容易得多。
