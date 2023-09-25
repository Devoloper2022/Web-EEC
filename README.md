# NTS Design Test Task 

### Requirement for the Task

- Framework: SPRING BOOT  
- Build pipeline: MAVEN 
- Database: PostgreSQL
- ReadMe file for description

### Installing and Running the Application

1. Clone the project repository to your computer:
```shell
git clone https://github.com/Devoloper2022/NTSDesign
```



### API Endpoints

1. upload

- Method: POST
- URL: /api/file/upload
- Request Body:

```
   File : Wanted File
```
2. Download

- Method: POST 
- URL: /api/file/Download
- Request Body:
```
fileName : file name
```

3. web Socket

- URL: /websocket
- Request Body
```
text : some message
```


