# MongoDB File Server（基于 MongoDB 的文件服务器）

#### Fork for my teacher and memory;

MongoDB File Server is a file server system based on MongoDB. MongoDB File Server is committed to the storage of small files, such as pictures in the blog, ordinary documents and so on.

It's using some very popular technology like:

* MongoDB 3.4.4
* Spring Boot 2.0.0.M7
* Thymeleaf 3.0.3.RELEASE
* Thymeleaf Layout Dialect 2.2.0
* Embedded MongoDB 2.0.0
* Gradle 4.4.1

基于 MongoDB 的文件服务器。MongoDB File Server 致力于小型文件的存储，比如博客中图片、普通文档等。由于MongoDB 支持多种数据格式的存储，对于二进制的存储自然也是不话下，所以可以很方便的用于存储文件。由于  MongoDB 的 BSON 文档对于数据量大小的限制（每个文档不超过16M），所以本文件服务器主要针对的是小型文件的存储。对于大型文件的存储（比如超过16M），MongoDB 官方已经提供了成熟的产品  [GridFS](https://docs.mongodb.com/manual/core/gridfs/)，读者朋友可以自行了解。


## Features 特性

* Easy to use.（易于使用）
* RESTful API.
* Chinese characters friendly.（中文友好）
* ...

## APIs

Here are useful APIs.

* GET  /files/{pageIndex}/{pageSize} : Paging query file list.(分页查询文件列表)
* GET  /files/{id} : Download file.(下载某个文件)
* GET  /view/{id} : View file online.(在线预览某个文件。比如，显示图片)
* POST /upload : Upload file.(上传文件)
* DELETE /{id} : Delete file.(删除文件)

```
server.address=localhost
server.port=8081

# Thymeleaf 
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.cache=false
spring.thymeleaf.mode=HTML5

# limit upload file size
spring.http.multipart.max-file-size=1024KB
spring.http.multipart.max-request-size=1024KB
```

`spring.http.multipart.max-file-size` and `spring.http.multipart.max-request-size` limit upload file never larger than 1MB.

NOTE: default configuration will use a embedded Mongo, that means data will never persist when the MongoDB File Server restart.

You can set `spring.data.mongodb.uri` property to configure additional settings such as the replica set.（支持配置独立运行的 MongoDB 的连接方式）:

```shell
spring.data.mongodb.uri=mongodb://user:secret@mongo1.example.com:12345,mongo2.example.com:23456/test
```

If you want to use a stanlne MongoDB server, comment out Embedded MongoDB dependencies in `build.gradle` file.（如果需要使用独立运行的 MongoDB，就把下面的依赖注释掉）:

```
dependencies {
	...
	// compile('de.flapdoodle.embed:de.flapdoodle.embed.mongo')
	...
}
```

