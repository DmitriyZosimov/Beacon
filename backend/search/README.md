# Search

## Launch Docker
1. Run the next command and find docker ip address:
```
ifconfig docker0
```
It will look like this:
```agsl
docker0: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        inet 172.17.0.1  netmask 255.255.0.0  broadcast 172.17.255.255
```
2. Open _/etc/postgresql/12/main/postgresql.conf_ and change _listen_addresses_ to ```listen_adresses='*'```. Don't forget to remove ```#```.
3. Open _/etc/postgresql/12/main/pg_hba.conf_ and add this line in the bottom: 
```agsl
host       all         all     172.17.0.0/16       md5
```
4. Restart Postgresql:
```agsl
sudo service postgresql restart
```
5. Replace ```localhost``` in all properties with docker IP address in application-local.properties:
```agsl
spring.datasource.url=jdbc:postgresql://172.17.0.1:5432/catalog
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://172.17.0.1:8180/realms/catalog
...
```
6. Run ``start.sh``:,
```agsl
sh start.sh
```
7. Go to [http://localhost:8020/](http://localhost:8020/)

To stop docker run:
```agsl
sh stop.sh
```