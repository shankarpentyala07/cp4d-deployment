import groovy.json.*



def tfInitalize() {
        dir('managed-openshift/aws/terraform'){
        echo 'Terraform Initalize...'
        sh "terraform init"
    } 
} 

def tfPlan() {
    dir('managed-openshift/aws/terraform'){
            echo 'Terraform plan...'
            def cpd_map=['enable':"${params.cpd_platform_enable}",'version':'4.0.5','channel':"v2.0"]
            def wkc_map=['enable':"${params.watson_knowledge_catalog_enable}",'version':'4.0.5','channel':"v1.0"]
            def dv_map=['enable':"${params.data_virtualization_enable}",'version':'1.7.5','channel':"v1.7"]
            def ae_map=['enable':"${params.analytics_engine_enable}",'version':'4.0.5','channel':"stable-v1"]
            def wsl_map=['enable':"${params.watson_studio_enable}",'version':'4.0.5','channel':"v2.0"]
            def wml_map=['enable':"${params.watson_machine_learning_enable}",'version':'4.0.5','channel':"v1.1"]
            def openscale_map=['enable':"${params.watson_ai_openscale_enable}",'version':'4.0.5','channel':"v1"]
            def spss_map=['enable':"${params.spss_modeler_enable}",'version':'4.0.5','channel':"v1.0"]
            def cde_map=['enable':"${params.cognos_dashboard_embedded_enable}",'version':'4.0.5','channel':"v1.0"]
            def ds_map=['enable':"${params.datastage_enable}",'version':'4.0.5','channel':"v1.0"]
            def db2wh_map=['enable':"${params.db2_warehouse_enable}",'version':'4.0.7','channel':"v1.0"]
            def db2oltp_map=['enable':"${params.db2_oltp_enable}",'version':'4.0.7','channel':"v1.0"]
            def ca_map=['enable':"${params.cognos_analytics_enable}",'version':'4.0.5','channel':"v4.0"]
            def mdm_map=['enable':"${params.master_data_management_enable}",'version':'1.1.175','channel':"1.1"]
            def do_map=['enable':"${params.decision_optimization_enable}",'version':'4.0.5','channel':"v4.0"]
            def pa_map=['enable':"${params.planning_analytics_enable}",'version':'4.0.5','channel':"v4.0"]
            def bigsql_map=['enable':"${params.bigsql_enable}",'version':'7.2.5','channel':"v7.2"]
           
            
    // sh "terraform plan -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}' -var 'availability_zone1=${params.availability_zone1}' -var 'base_domain=${params.base_domain}' -var 'cpd_api_key=${params.cpd_api_key}'  -var 'cpd_external_username=${params.cpd_external_username}' -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_replica_count=${params.worker_replica_count}' -var 'openshift_pull_secret_file_path=${params.openshift_pull_secret_file_path}' -var 'openshift_username=${params.openshift_username}' -var 'openshift_password=${params.openshift_password}' -var 'accept_cpd_license=${params.accept_cpd_license}' -var 'public_ssh_key=${params.public_ssh_key}' "
  sh "terraform plan -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}' -var 'rosa_token=${params.ROSA_TOKEN}' -var 'cpd_api_key=${params.cpd_api_key}'  -var 'cpd_external_username=${params.cpd_external_username}' -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_machine_type=${params.worker_machine_type}' -var 'worker_machine_count=${params.worker_machine_count}' -var 'private_cluster=${params.private_cluster}' -var 'accept_cpd_license=${params.accept_cpd_license}'  -var 'cpd_platform=${JsonOutput.toJson(cpd_map)}' -var 'watson_knowledge_catalog=${JsonOutput.toJson(wkc_map)}' -var 'data_virtualization=${JsonOutput.toJson(dv_map)}' -var 'analytics_engine=${JsonOutput.toJson(ae_map)}' -var 'watson_studio=${JsonOutput.toJson(wsl_map)}' -var 'watson_machine_learning=${JsonOutput.toJson(wml_map)}' -var 'watson_ai_openscale=${JsonOutput.toJson(openscale_map)}' -var 'spss_modeler=${JsonOutput.toJson(spss_map)}' -var 'cognos_dashboard_embedded=${JsonOutput.toJson(cde_map)}' -var 'datastage=${JsonOutput.toJson(ds_map)}' -var 'db2_warehouse=${JsonOutput.toJson(db2wh_map)}' -var 'db2_oltp=${JsonOutput.toJson(db2oltp_map)}' -var 'cognos_analytics=${JsonOutput.toJson(ca_map)}' -var 'master_data_management=${JsonOutput.toJson(mdm_map)}' -var 'decision_optimization=${JsonOutput.toJson(do_map)}'  -var 'planning_analytics=${JsonOutput.toJson(pa_map)}'  -var 'bigsql=${JsonOutput.toJson(bigsql_map)}' "

    } 
}

def tfApply() {
    dir('managed-openshift/aws/terraform'){
            echo 'Terraform Apply Auto Approve...'
            def cpd_map=['enable':"${params.cpd_platform_enable}",'version':'4.0.5','channel':"v2.0"]
            def wkc_map=['enable':"${params.watson_knowledge_catalog_enable}",'version':'4.0.5','channel':"v1.0"]
            def dv_map=['enable':"${params.data_virtualization_enable}",'version':'1.7.5','channel':"v1.7"]
            def ae_map=['enable':"${params.analytics_engine_enable}",'version':'4.0.5','channel':"stable-v1"]
            def wsl_map=['enable':"${params.watson_studio_enable}",'version':'4.0.5','channel':"v2.0"]
            def wml_map=['enable':"${params.watson_machine_learning_enable}",'version':'4.0.5','channel':"v1.1"]
            def openscale_map=['enable':"${params.watson_ai_openscale_enable}",'version':'4.0.5','channel':"v1"]
            def spss_map=['enable':"${params.spss_modeler_enable}",'version':'4.0.5','channel':"v1.0"]
            def cde_map=['enable':"${params.cognos_dashboard_embedded_enable}",'version':'4.0.5','channel':"v1.0"]
            def ds_map=['enable':"${params.datastage_enable}",'version':'4.0.5','channel':"v1.0"]
            def db2wh_map=['enable':"${params.db2_warehouse_enable}",'version':'4.0.7','channel':"v1.0"]
            def db2oltp_map=['enable':"${params.db2_oltp_enable}",'version':'4.0.7','channel':"v1.0"]
            def ca_map=['enable':"${params.cognos_analytics_enable}",'version':'4.0.5','channel':"v4.0"]
            def mdm_map=['enable':"${params.master_data_management_enable}",'version':'1.1.175','channel':"1.1"]
            def do_map=['enable':"${params.decision_optimization_enable}",'version':'4.0.5','channel':"v4.0"]
            def pa_map=['enable':"${params.planning_analytics_enable}",'version':'4.0.5','channel':"v4.0"]
            def bigsql_map=['enable':"${params.bigsql_enable}",'version':'7.2.5','channel':"v7.2"]


           // sh "terraform apply -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}' -var 'base_domain=${params.base_domain}' -var 'cpd_api_key=${params.cpd_api_key}' -var 'cpd_external_username=${params.cpd_external_username}'  -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_replica_count=${params.worker_replica_count}' -var 'openshift_pull_secret_file_path=${params.openshift_pull_secret_file_path}' -var 'openshift_username=${params.openshift_username}' -var 'openshift_password=${params.openshift_password}' -var 'accept_cpd_license=${params.accept_cpd_license}' -var 'public_ssh_key=${params.public_ssh_key}' -var 'cpd_platform=${JsonOutput.toJson(cpd_map)}'    -var 'watson_knowledge_catalog=${JsonOutput.toJson(wkc_map)}' -var 'data_virtualization=${JsonOutput.toJson(dv_map)}' -var 'analytics_engine=${JsonOutput.toJson(ae_map)}' -var 'watson_studio=${JsonOutput.toJson(wsl_map)}' -var 'watson_machine_learning=${JsonOutput.toJson(wml_map)}' -var 'watson_ai_openscale=${JsonOutput.toJson(openscale_map)}' -var 'spss_modeler=${JsonOutput.toJson(spss_map)}' -var 'cognos_dashboard_embedded=${JsonOutput.toJson(cde_map)}' -var 'datastage=${JsonOutput.toJson(ds_map)}' -var 'db2_warehouse=${JsonOutput.toJson(db2wh_map)}' -var 'db2_oltp=${JsonOutput.toJson(db2oltp_map)}' -var 'cognos_analytics=${JsonOutput.toJson(ca_map)}' -var 'master_data_management=${JsonOutput.toJson(mdm_map)}' -var 'decision_optimization=${JsonOutput.toJson(do_map)}'  -var 'planning_analytics=${JsonOutput.toJson(pa_map)}'  -var 'bigsql=${JsonOutput.toJson(bigsql_map)}'  --auto-approve"
        sh "terraform apply -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}' -var 'rosa_token=${params.ROSA_TOKEN}' -var 'cpd_api_key=${params.cpd_api_key}'  -var 'cpd_external_username=${params.cpd_external_username}' -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_machine_type=${params.worker_machine_type}' -var 'worker_machine_count=${params.worker_machine_count}' -var 'private_cluster=${params.private_cluster}' -var 'accept_cpd_license=${params.accept_cpd_license}'  -var 'cpd_platform=${JsonOutput.toJson(cpd_map)}' -var 'watson_knowledge_catalog=${JsonOutput.toJson(wkc_map)}' -var 'data_virtualization=${JsonOutput.toJson(dv_map)}' -var 'analytics_engine=${JsonOutput.toJson(ae_map)}' -var 'watson_studio=${JsonOutput.toJson(wsl_map)}' -var 'watson_machine_learning=${JsonOutput.toJson(wml_map)}' -var 'watson_ai_openscale=${JsonOutput.toJson(openscale_map)}' -var 'spss_modeler=${JsonOutput.toJson(spss_map)}' -var 'cognos_dashboard_embedded=${JsonOutput.toJson(cde_map)}' -var 'datastage=${JsonOutput.toJson(ds_map)}' -var 'db2_warehouse=${JsonOutput.toJson(db2wh_map)}' -var 'db2_oltp=${JsonOutput.toJson(db2oltp_map)}' -var 'cognos_analytics=${JsonOutput.toJson(ca_map)}' -var 'master_data_management=${JsonOutput.toJson(mdm_map)}' -var 'decision_optimization=${JsonOutput.toJson(do_map)}'  -var 'planning_analytics=${JsonOutput.toJson(pa_map)}'  -var 'bigsql=${JsonOutput.toJson(bigsql_map)}'  --auto-approve"

        } 
} 

def tfDestroy(){
        dir('managed-openshift/aws/terraform'){
        echo 'Terraform destroy Auto Approve...'
        def cpd_map=['enable':"${params.cpd_platform_enable}",'version':'4.0.5','channel':"v2.0"]
        def wkc_map=['enable':"${params.watson_knowledge_catalog_enable}",'version':'4.0.5','channel':"v1.0"]
        def dv_map=['enable':"${params.data_virtualization_enable}",'version':'1.7.5','channel':"v1.7"]
        def ae_map=['enable':"${params.analytics_engine_enable}",'version':'4.0.5','channel':"stable-v1"]
        def wsl_map=['enable':"${params.watson_studio_enable}",'version':'4.0.5','channel':"v2.0"]
        def wml_map=['enable':"${params.watson_machine_learning_enable}",'version':'4.0.5','channel':"v1.1"]
        def openscale_map=['enable':"${params.watson_ai_openscale_enable}",'version':'4.0.5','channel':"v1"]
        def spss_map=['enable':"${params.spss_modeler_enable}",'version':'4.0.5','channel':"v1.0"]
        def cde_map=['enable':"${params.cognos_dashboard_embedded_enable}",'version':'4.0.5','channel':"v1.0"]
        def ds_map=['enable':"${params.datastage_enable}",'version':'4.0.5','channel':"v1.0"]
        def db2wh_map=['enable':"${params.db2_warehouse_enable}",'version':'4.0.7','channel':"v1.0"]
        def db2oltp_map=['enable':"${params.db2_oltp_enable}",'version':'4.0.7','channel':"v1.0"]
        def ca_map=['enable':"${params.cognos_analytics_enable}",'version':'4.0.5','channel':"v4.0"]
        def mdm_map=['enable':"${params.master_data_management_enable}",'version':'1.1.175','channel':"1.1"]
        def do_map=['enable':"${params.decision_optimization_enable}",'version':'4.0.5','channel':"v4.0"]
        def pa_map=['enable':"${params.planning_analytics_enable}",'version':'4.0.5','channel':"v4.0"]
        def bigsql_map=['enable':"${params.bigsql_enable}",'version':'7.2.5','channel':"v7.2"]
        
       // sh "terraform destroy -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}'  -var 'base_domain=${params.base_domain}' -var 'cpd_api_key=${params.cpd_api_key}' -var 'cpd_external_username=${params.cpd_external_username}'  -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_replica_count=${params.worker_replica_count}' -var 'openshift_pull_secret_file_path=${params.openshift_pull_secret_file_path}' -var 'openshift_username=${params.openshift_username}' -var 'openshift_password=${params.openshift_password}' -var 'accept_cpd_license=${params.accept_cpd_license}' -var 'public_ssh_key=${params.public_ssh_key}' -var 'cpd_platform=${JsonOutput.toJson(cpd_map)}'   -var 'watson_knowledge_catalog=${JsonOutput.toJson(wkc_map)}' -var 'data_virtualization=${JsonOutput.toJson(dv_map)}' -var 'analytics_engine=${JsonOutput.toJson(ae_map)}' -var 'watson_studio=${JsonOutput.toJson(wsl_map)}' -var 'watson_machine_learning=${JsonOutput.toJson(wml_map)}' -var 'watson_ai_openscale=${JsonOutput.toJson(openscale_map)}' -var 'spss_modeler=${JsonOutput.toJson(spss_map)}' -var 'cognos_dashboard_embedded=${JsonOutput.toJson(cde_map)}' -var 'datastage=${JsonOutput.toJson(ds_map)}' -var 'db2_warehouse=${JsonOutput.toJson(db2wh_map)}' -var 'db2_oltp=${JsonOutput.toJson(db2oltp_map)}' -var 'cognos_analytics=${JsonOutput.toJson(ca_map)}' -var 'master_data_management=${JsonOutput.toJson(mdm_map)}' -var 'decision_optimization=${JsonOutput.toJson(do_map)}'  -var 'planning_analytics=${JsonOutput.toJson(pa_map)}'  -var 'bigsql=${JsonOutput.toJson(bigsql_map)}'  --auto-approve"
      sh "terraform destroy -var 'access_key_id=${params.AWS_ACCESS_KEY_ID}' -var 'secret_access_key=${params.AWS_SECRET_ACCESS_KEY}' -var 'region=${params.region}' -var 'az=${params.az}' -var 'rosa_token=${params.ROSA_TOKEN}' -var 'cpd_api_key=${params.cpd_api_key}'  -var 'cpd_external_username=${params.cpd_external_username}' -var 'cpd_external_registry=${params.cpd_external_registry}' -var 'cluster_name=${params.cluster_name}' -var 'worker_machine_type=${params.worker_machine_type}' -var 'worker_machine_count=${params.worker_machine_count}' -var 'private_cluster=${params.private_cluster}' -var 'accept_cpd_license=${params.accept_cpd_license}'  -var 'cpd_platform=${JsonOutput.toJson(cpd_map)}' -var 'watson_knowledge_catalog=${JsonOutput.toJson(wkc_map)}' -var 'data_virtualization=${JsonOutput.toJson(dv_map)}' -var 'analytics_engine=${JsonOutput.toJson(ae_map)}' -var 'watson_studio=${JsonOutput.toJson(wsl_map)}' -var 'watson_machine_learning=${JsonOutput.toJson(wml_map)}' -var 'watson_ai_openscale=${JsonOutput.toJson(openscale_map)}' -var 'spss_modeler=${JsonOutput.toJson(spss_map)}' -var 'cognos_dashboard_embedded=${JsonOutput.toJson(cde_map)}' -var 'datastage=${JsonOutput.toJson(ds_map)}' -var 'db2_warehouse=${JsonOutput.toJson(db2wh_map)}' -var 'db2_oltp=${JsonOutput.toJson(db2oltp_map)}' -var 'cognos_analytics=${JsonOutput.toJson(ca_map)}' -var 'master_data_management=${JsonOutput.toJson(mdm_map)}' -var 'decision_optimization=${JsonOutput.toJson(do_map)}'  -var 'planning_analytics=${JsonOutput.toJson(pa_map)}'  -var 'bigsql=${JsonOutput.toJson(bigsql_map)}' --auto-approve "

    } 
}

return this
