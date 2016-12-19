package org.zstack.sdk;

import java.util.HashMap;
import java.util.Map;

public class RemoveVmNicFromLoadBalancerAction extends AbstractAction {

    private static final HashMap<String, Parameter> parameterMap = new HashMap<>();

    public static class Result {
        public ErrorCode error;
        public RemoveVmNicFromLoadBalancerResult value;
    }

    @Param(required = true, nonempty = true, nullElements = false, emptyString = true, noTrim = false)
    public java.util.List vmNicUuids;

    @Param(required = true, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String listenerUuid;

    @Param(required = false)
    public java.util.List systemTags;

    @Param(required = false)
    public java.util.List userTags;

    @Param(required = true)
    public String sessionId;

    public long timeout;
    
    public long pollingInterval;


    public Result call() {
        ApiResult res = ZSClient.call(this);
        Result ret = new Result();
        if (res.error != null) {
            ret.error = res.error;
            return ret;
        }
        
        RemoveVmNicFromLoadBalancerResult value = res.getResult(RemoveVmNicFromLoadBalancerResult.class);
        ret.value = value == null ? new RemoveVmNicFromLoadBalancerResult() : value;
        return ret;
    }

    public void call(final Completion<Result> completion) {
        ZSClient.call(this, new InternalCompletion() {
            @Override
            public void complete(ApiResult res) {
                Result ret = new Result();
                if (res.error != null) {
                    ret.error = res.error;
                    completion.complete(ret);
                    return;
                }
                
                RemoveVmNicFromLoadBalancerResult value = res.getResult(RemoveVmNicFromLoadBalancerResult.class);
                ret.value = value == null ? new RemoveVmNicFromLoadBalancerResult() : value;
                completion.complete(ret);
            }
        });
    }

    Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    RestInfo getRestInfo() {
        RestInfo info = new RestInfo();
        info.httpMethod = "DELETE";
        info.path = "/load-balancers/listeners/{listenerUuid}/vm-instances/nics";
        info.needSession = true;
        info.needPoll = true;
        info.parameterName = "params";
        return info;
    }

}