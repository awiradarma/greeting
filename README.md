# greeting project

Using Quarkus and gradle plugin on Google Cloud App Engine

## Steps

- Create a new project and associate it with the billing account (required for Cloud Build)
```
gcloud projects create --name "Quarkus sample project" 
gcloud beta billing accounts list
gcloud beta billing projects link <PROJECT_ID> --billing-account=<ACCOUNT_ID>
gcloud beta billing projects list --billing-account=<ACCOUNT_ID>
```
- Configure gcloud to point to that project
```
gcloud config set project <project-id>
export GOOGLE_CLOUD_PROJECT=<project-id>
```
- Enable Google Cloud Build API
```
gcloud services enable cloudbuild.googleapis.com
```
- Create a new app 
```
gcloud app create
``` 
- Build this project as uber-jar
```
./gradlew clean build -Dquarkus.package.type=uber-jar
```
- Deploy to app engine
```
./gradlew appengineDeploy
```
- Validate
```
gcloud app browse
```
- Delete the project when you're done to remove all resources
```
gcloud projects delete <project-id>
```

## References
[Quarkus quickstart](https://dzone.com/articles/quarkus-quickstart-deployment-for-the-hello-world)