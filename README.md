# cuping-project
![1](https://github.com/cuping-project/cuping-fe/assets/55288856/912c0f95-b3e2-469c-bf90-1288efe435b9)

> 프로젝트 소개 영상
- [https://www.youtube.com/watch?v=53dH4lfc2Lw](https://www.youtube.com/watch?v=EY7-kMef_20)

> 프로젝트 노션 페이지
- https://www.notion.so/5-9e3042ff4b354ce7b20e3a8095b29e98
<br/>
<br/>
<br/>

> **서비스 소개**
#
- 커핑은 근처 지역에서 좋아하는 원두를 찾아 즐길 수 있는 원두 기반 카페 검색 서비스입니다.
- `일반 사용자`는 지역 기반 검색을 통해 원두 기반으로 카페를 찾고 검색하실 수 있습니다.
- `카페 관리자`는 본인 가게에서 보유하고 있는 원두를 등록하고, 가게 정보도 등록하실 수 있습니다.
<br/>
<br/>
<br/>

> **서비스 이용해보기**
#
- https://cuping.net/
<br/>
<br/>
<br/>

> **서비스 주요기능**
#
- 원하는 원두 검색 기능
- 해당 원두를 소지하고 있는 내 주변 카페 위치 지도 제공
- 댓글로 소통하는 원두에 대한 커뮤니티 기능
<br/>
<br/>
<br/>

>**기술스택**
#
<br/> <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=aws&logoColor=white"> <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"/> <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"/>  <img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=for-the-badge&logo=SpringSecurity&logoColor=white"/> <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/> <img src="https://img.shields.io/badge/JsonWebTokens-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white"> <img src="https://img.shields.io/badge/AmazonRDS-527FFF?style=for-the-badge&logo=AmazonRDS&logoColor=white"/> <img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white"/> <img src="https://img.shields.io/badge/AWS Route 53-FF6C37?style=for-the-badge&logoColor=white"> <img src="https://img.shields.io/badge/https-527FFF?style=for-the-badge"> <img src="https://img.shields.io/badge/AmazonEC2-FF9900?style=for-the-badge&logo=AmazonEC2&logoColor=white"/> <img src="https://img.shields.io/badge/AmazonS3-569A31?style=for-the-badge&logo=AmazonS3&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"/> <img src="https://camo.githubusercontent.com/54a2f74f3cbb3cb810faa417fb9a56b4d947be01e868ab624b3f251a1062257b/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f67697468756220616374696f6e732d3230383846463f7374796c653d666f722d7468652d6261646765266c6f676f3d67697468756220616374696f6e73266c6f676f436f6c6f723d7768697465"> <img src="https://camo.githubusercontent.com/a831a652fb5370367ee71ae4255e39623b9edf7e60ffbcf7ba356b1d82a09538/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672064617461206a70612d4632384431413f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67646174616a7061266c6f676f436f6c6f723d7768697465">
<br/>
<br/>
<br/>

> **아키텍처**
#
<img width="1181" alt="스크린샷 2023-06-26 오전 7 50 15" src="https://github.com/Jangkiwoong/Node.js.login/assets/110136582/214105f8-2bd6-4706-b605-8275e3244601">
<br/>

> **기술적 의사결정**
#
|사용기술|의사결정|
|:---:|:---|
|Redis|무중단 배포 설정 중 설정이 완료됐다고 생각하고 실행했는데 실패하는 문제 발생|
|GitHub Action|배포가 실패한 이유를 확인해보니does not give you permission to perform operations in the following AWS service라는 문구가 있었고 권한이 없다고 생각함.|
|AWS CodeDeploy|관련 글을 찾아보던 도중 Json형식으로 권하는 생성하는 글을 찾았고 해당 권한을 부여 후무중단 배포 성공.|
|Amazon S3|원두, 사업자 등록증에 대한 이미지 파일을 업로드 하고 CI/CD 코드 저장을 위해 채택|
|ALB|무중단 배포시 서버를 구버전에서 신버전으로 라우트 하기 위해 사용|
|AutoScaling|무중단 배포시 블루 그린을 선택했고 구현을 위해서 AutoScaling 그룹 복사를 선택하기 위해서 선택 요청이 많이지면 자동으로 인스턴스를 추가 생성하여 운영 가능.|
|QueryDsl|필터링, 무한스크롤을 위해 동적쿼리 추가|
<br/>
<br/>
<br/>

> **ERD**
#
![erd](https://github.com/Jangkiwoong/Node.js.login/assets/110136582/a1d34fbb-689a-4519-83a7-05f8d18ad63b)
<br/>
<br/>
<br/>

> **트러블 슈팅**
#
<details>
<summary>무중단 배포 권한 문제 발생</summary>
<div markdown="1">
    
|진행  순서|내용|
|:---:|:---|
|문제|무중단 배포 설정 중 설정이 완료됐다고 생각하고 실행했는데 실패하는 문제 발생|
|시도|배포가 실패한 이유를 확인해보니does not give you permission to perform operations in the following AWS service라는 문구가 있었고 권한이 없다고 생각함.|
|해결|관련 글을 찾아보던 도중 Json형식으로 권하는 생성하는 글을 찾았고 해당 권한을 부여 후무중단 배포 성공.|

{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": [
                "iam:PassRole",
                "ec2:CreateTags",
                "ec2:RunInstances"
            ],
            "Resource": "*"
        }
    ]
}
</div>
</details>
<details>
<summary>이미지 로딩시간 지연</summary>
<div markdown="1">
    
|진행  순서|내용|
|:---:|:---|
|문제|S3에 저장되어 있는 이미지 용량이 너무 커 페이지에서 이미지 로딩 시간이 지연됨|
|시도|S3에 저장되어 있는 이미지 용량이 너무 커 페이지에서 이미지 로딩 시간이 지연됨 AWS Lamda를 사용하여 이미지 리사이징을 하려 했으나 S3의 용량이 커진다는 문제와 원본 사진을 저장할 필요가 없어 라이브러리를 사용|
|해결|marvin 라이브러리를 사용하여 2MB에서 976KB 로 이미지 용량 축소|
</div>
</details>

![화면_캡처_2023-06-26_220122-removebg-preview](https://github.com/Jangkiwoong/Node.js.login/assets/110136582/4ed362dd-6363-4dd9-9aed-5772e145fbb7)

> **시기**
> 
- 프로젝트 진행 기간
    - 2023.5 ~ 2023.6 (6주)
