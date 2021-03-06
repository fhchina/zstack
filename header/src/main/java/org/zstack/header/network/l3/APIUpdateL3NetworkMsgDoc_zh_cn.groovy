package org.zstack.header.network.l3

import org.zstack.header.network.l3.APIUpdateL3NetworkEvent

doc {
    title "UpdateL3Network"

    category "network.l3"

    desc "在这里填写API描述"

    rest {
        request {
			url "PUT /v1/l3-networks/{uuid}/actions"


            header (OAuth: 'the-session-uuid')

            clz APIUpdateL3NetworkMsg.class

            desc ""
            
			params {

				column {
					name "uuid"
					enclosedIn "updateL3Network"
					desc "资源的UUID，唯一标示该资源"
					location "url"
					type "String"
					optional false
					since "0.6"
					
				}
				column {
					name "name"
					enclosedIn "updateL3Network"
					desc "资源名称"
					location "body"
					type "String"
					optional true
					since "0.6"
					
				}
				column {
					name "description"
					enclosedIn "updateL3Network"
					desc "资源的详细描述"
					location "body"
					type "String"
					optional true
					since "0.6"
					
				}
				column {
					name "system"
					enclosedIn "updateL3Network"
					desc ""
					location "body"
					type "Boolean"
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
            clz APIUpdateL3NetworkEvent.class
        }
    }
}