# Spring Cloud 框架Demo
demo 来源 [将Spring Cloud应用托管到SAE](https://help.aliyun.com/document_detail/123013.html)
基于上述代码做了简单调整

## Start up Nacos Registry
```bash
wget https://github.com/alibaba/nacos/releases/download/2.0.3/nacos-server-2.0.3.tar.gz
tar –xvf nacos-server-2.0.3.tar.gz
sh nacos/bin/startup.sh -m standalone
```