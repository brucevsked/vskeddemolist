
http://localhost:8080/testsession/
http://localhost:8080/testsession/lost.jsp
http://localhost:8080/testsession/test2.jsp
http://localhost:8080/testsession/test3.jsp

http://192.168.1.97/testsession/

修改
ehcacheConfig.xml
一个内容为

<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:noNamespaceSchemaLocation="ehcache.xsd">
  <diskStore path="java.io.tmpdir"/>
  <defaultCache
    maxElementsInMemory="50000"
    maxElementsOnDisk="100000"
    eternal="true"
    overflowToDisk="true"
    diskPersistent="false"
    timeToIdleSeconds="0"
    timeToLiveSeconds="0"
    diskSpoolBufferSizeMB="50"
    diskExpiryThreadIntervalSeconds="120"
    memoryStoreEvictionPolicy="LFU"
    />
  <cache name="demoCache"
    maxElementsInMemory="500000"
    maxElementsOnDisk="100000"
    eternal="true" 
    overflowToDisk="true"
    diskPersistent="false"
    timeToIdleSeconds="119"
    timeToLiveSeconds="119"
    diskSpoolBufferSizeMB="50"
    diskExpiryThreadIntervalSeconds="120"
    memoryStoreEvictionPolicy="FIFO"
    />
    
    <cacheManagerPeerProviderFactory  
        class="net.sf.ehcache.distribution.RMICacheManagerPeerProviderFactory"  
        properties="peerDiscovery=manual,  
        rmiUrls=//localhost:40001/demoCache" /> 
          
<cacheManagerPeerListenerFactory  
class="net.sf.ehcache.distribution.RMICacheManagerPeerListenerFactory"  
properties="hostName=localhost, port=40000, socketTimeoutMillis=1000"/> 
 
</ehcache>

-------------------------------------------------------------------------------

<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:noNamespaceSchemaLocation="ehcache.xsd">
  <diskStore path="java.io.tmpdir"/>
  <defaultCache
    maxElementsInMemory="50000"
    maxElementsOnDisk="100000"
    eternal="true"
    overflowToDisk="true"
    diskPersistent="false"
    timeToIdleSeconds="0"
    timeToLiveSeconds="0"
    diskSpoolBufferSizeMB="50"
    diskExpiryThreadIntervalSeconds="120"
    memoryStoreEvictionPolicy="LFU"
    />
  <cache name="demoCache"
    maxElementsInMemory="500000"
    maxElementsOnDisk="100000"
    eternal="true" 
    overflowToDisk="true"
    diskPersistent="false"
    timeToIdleSeconds="119"
    timeToLiveSeconds="119"
    diskSpoolBufferSizeMB="50"
    diskExpiryThreadIntervalSeconds="120"
    memoryStoreEvictionPolicy="FIFO"
    />
    
    <cacheManagerPeerProviderFactory  
        class="net.sf.ehcache.distribution.RMICacheManagerPeerProviderFactory"  
        properties="peerDiscovery=manual,  
        rmiUrls=//localhost:40000/demoCache" /> 
          
<cacheManagerPeerListenerFactory  
class="net.sf.ehcache.distribution.RMICacheManagerPeerListenerFactory"  
properties="hostName=localhost, port=40001, socketTimeoutMillis=1000"/> 
 
</ehcache>

-------------------------------------------------------------------------------