def tfInitalize() {
        dir('selfmanaged-openshift/aws'){
        echo 'Terraform Initalize...'
        sh "terraform init"
    } 
} 

def tfPlan() {
    dir('selfmanaged-openshift/aws'){
            echo 'Terraform plan...'
            sh "terraform plan -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}' -var 'availability_zone1=${params.availability_zone1}' -var 'base_domain=${params.base_domain}' -var 'cpd_api_key=${params.cpd_api_key}'  -var 'cpd_external_username=${params.cpd_external_username}' -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_replica_count=${params.worker_replica_count}' -var 'openshift_pull_secret_file_path=${params.openshift_pull_secret_file_path}' -var 'openshift_username=${params.openshift_username}' -var 'openshift_password=${params.openshift_password}' -var 'accept_cpd_license=${params.accept_cpd_license}' -var 'public_ssh_key=${params.public_ssh_key}' -var 'watson_knowledge_catalog=${JsonOutput.toJson(["enable":${params.watson_knowledge_catalog},"version":"4.0.5","channel":"v1.0" ])}'"
        } 
} 

def tfApply() {
    dir('selfmanaged-openshift/aws'){
            echo 'Terraform Apply Auto Approve...'
            // sh "terraform apply -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}' -var 'availability_zone1=${params.availability_zone1}' -var 'base_domain=${params.base_domain}' -var 'cpd_api_key=${params.cpd_api_key}' -var 'cpd_external_username=${params.cpd_external_username}'  -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_replica_count=${params.worker_replica_count}' -var 'openshift_pull_secret_file_path=${params.openshift_pull_secret_file_path}' -var 'openshift_username=${params.openshift_username}' -var 'openshift_password=${params.openshift_password}' -var 'accept_cpd_license=${params.accept_cpd_license}' -var 'public_ssh_key=${params.public_ssh_key}' --auto-approve"
        } 
} 

def tfDestroy(){
        dir('selfmanaged-openshift/aws'){
        echo 'Terraform destroy Auto Approve...'
        // sh "terraform destroy -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}' -var 'availability_zone1=${params.availability_zone1}' -var 'base_domain=${params.base_domain}' -var 'cpd_api_key=${params.cpd_api_key}' -var 'cpd_external_username=${params.cpd_external_username}'  -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_replica_count=${params.worker_replica_count}' -var 'openshift_pull_secret_file_path=${params.openshift_pull_secret_file_path}' -var 'openshift_username=${params.openshift_username}' -var 'openshift_password=${params.openshift_password}' -var 'accept_cpd_license=${params.accept_cpd_license}' -var 'public_ssh_key=${params.public_ssh_key}' --auto-approve"
    } 
}

return this
