package org.zstack.network.service.lb

import org.zstack.network.service.lb.APICreateLoadBalancerEvent

doc {
    title "CreateLoadBalancer"

    category "loadBalancer"

    desc "在这里填写API描述"

    rest {
        request {
			url "POST /v1/load-balancers"


            header (OAuth: 'the-session-uuid')

            clz APICreateLoadBalancerMsg.class

            desc ""
            
			params {

				column {
					name "name"
					enclosedIn ""
					desc "资源名称"
					location "body"
					type "String"
					optional false
					since "0.6"
					
				}
				column {
					name "description"
					enclosedIn ""
					desc "资源的详细描述"
					location "body"
					type "String"
					optional true
					since "0.6"
					
				}
				column {
					name "vipUuid"
					enclosedIn ""
					desc "VIP UUID"
					location "body"
					type "String"
					optional false
					since "0.6"
					
				}
				column {
					name "resourceUuid"
					enclosedIn ""
					desc ""
					location "body"
					type "String"
					optional true
					since "0.6"
					
				}
				column {
					name "systemTags"
					enclosedIn ""
					desc "系统标签"
					location "body"
					type "List"
					optional true
					since "0.6"
					
				}
				column {
					name "userTags"
					enclosedIn ""
					desc "用户标签"
					location "body"
					type "List"
					optional true
					since "0.6"
					
				}
			}
        }

        response {
            clz APICreateLoadBalancerEvent.class
        }
    }
}