package org.zstack.sdk;

import java.util.HashMap;
import java.util.Map;

public class CreateRootVolumeTemplateFromRootVolumeAction extends AbstractAction {

    private static final HashMap<String, Parameter> parameterMap = new HashMap<>();

    public static class Result {
        public ErrorCode error;
        public CreateRootVolumeTemplateFromRootVolumeResult value;
    }

    @Param(required = true, maxLength = 255, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String name;

    @Param(required = false, maxLength = 2048, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String description;

    @Param(required = false)
    public java.lang.String guestOsType;

    @Param(required = false, nonempty = true, nullElements = false, emptyString = true, noTrim = false)
    public java.util.List backupStorageUuids;

    @Param(required = true, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String rootVolumeUuid;

    @Param(required = false, validValues = {"Linux","Windows","Other","Paravirtualization","WindowsVirtio"}, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String platform;

    @Param(required = false)
    public boolean system;

    @Param(required = false)
    public java.lang.String resourceUuid;

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
        
        CreateRootVolumeTemplateFromRootVolumeResult value = res.getResult(CreateRootVolumeTemplateFromRootVolumeResult.class);
        ret.value = value == null ? new CreateRootVolumeTemplateFromRootVolumeResult() : value;
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
                
                CreateRootVolumeTemplateFromRootVolumeResult value = res.getResult(CreateRootVolumeTemplateFromRootVolumeResult.class);
                ret.value = value == null ? new CreateRootVolumeTemplateFromRootVolumeResult() : value;
                completion.complete(ret);
            }
        });
    }

    Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    RestInfo getRestInfo() {
        RestInfo info = new RestInfo();
        info.httpMethod = "POST";
        info.path = "/images/root-volume-templates/from/volumes/{rootVolumeUuid}";
        info.needSession = true;
        info.needPoll = true;
        info.parameterName = "params";
        return info;
    }

}