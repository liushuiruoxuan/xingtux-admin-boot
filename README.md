#### 1.先在[generator.properties](src%2Fmain%2Fresources%2Fgenerator.properties) 配置好信息
######  1.1 生成的项目路径： projectPath=E:/meProject/MBGPlus （必须）
######  1.2 如果是单模块，则不需要配置，如果是多模块，则配置子模块的模块名： moduleName= （非必须）
######  1.3 父级包名 ：packagePath=com.generator.chai （必须）
######  1.4 作者： author=自己名字 （非必须）
######  1.5 生成的表名，多个用逗号分割：tables=t_tenement_device （必须）
######  1.6 去除表前缀，多个用逗号分割：tablePrefix=t_
######  1.7 数据库连接
###### database.url=jdbc:mysql://自己的数据库地址:端口号/数据库?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull&allowPublicKeyRetrieval=true
###### database.username=root
###### database.password=

#### 2.运行[NewGenRun.java](src%2Fmain%2Fjava%2Fcom%2Fgenerator%2Fmbgplus%2FNewGenRun.java)
