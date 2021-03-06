package org.zstack.header.network.l3

import org.zstack.header.network.l3.APIQueryIpRangeReply
import org.zstack.header.query.APIQueryMessage

doc {
    title "QueryIpRange"

    category "network.l3"

    desc "在这里填写API描述"

    rest {
        request {
			url "GET /v1/l3-networks/ip-ranges"

			url "GET /v1l3-networks/ip-ranges/{uuid}"


            header (OAuth: 'the-session-uuid')

            clz APIQueryIpRangeMsg.class

            desc ""
            
			params APIQueryMessage.class
        }

        response {
            clz APIQueryIpRangeReply.class
        }
    }
}