sudo docker run -itd --name mysql-master -p 3306:3306 -v /home/zhc/master/my.cnf:/etc/my.cnf  -e MYSQL_ROOT_PASSWORD=123456  mysql  

docker images 查看镜像

docker ps -a 显示所有容器

docker exec -it 243c32535da7 /bin/bash  进入容器 


sudo docker run -itd --name mysql-slave -p 3307:3306 -v /home/zhc/slave/my.cnf:/etc/my.cnf  -e MYSQL_ROOT_PASSWORD=123456  mysql 


Zabbix监控系统，基于c+php开发的开源监控系统，支持多种监控采集方式，应用广泛，支持比较成熟，社区活跃，缺点是对容器支持度比较差。

Prometheus监控系统，基于go开发的开源监控系统，支持pull和push两种采集模式，有完整的监控、报警、展示、数据异地传输能力，配置简单，对容器支持良好。

由于目前使用的MySQL在云上部署，而且公司现有对PaaS云监控基于Promehteus，因此，方案二是更佳选项，既能满足MySQL监控，又能充分利用现有资源。