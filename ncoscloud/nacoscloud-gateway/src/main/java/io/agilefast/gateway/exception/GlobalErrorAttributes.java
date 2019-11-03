package io.agilefast.gateway.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Component
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public GlobalErrorAttributes() {
        super(false);
    }

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        return assembleError(request);
    }

    private Map<String, Object> assembleError(ServerRequest request) {
        Map<String, Object> errorAttributes = new LinkedHashMap<>();
        Throwable error = getError(request);
        if (error instanceof ServerException) {
            errorAttributes.put("code", ((ServerException) error).getCode().getCode());
            errorAttributes.put("msg", error.getMessage());
        } else {
            log.info("错误异常：{}",error.getMessage());
            if (error.getMessage().contains(String.valueOf(HttpStatus.NOT_FOUND.value()))){
                errorAttributes.put("code", HttpStatus.NOT_FOUND.value());
                errorAttributes.put("msg", HttpStatus.NOT_FOUND.getReasonPhrase());
            } else {
                errorAttributes.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
                errorAttributes.put("msg", "GATEWAY ERROR");
            }

        }
        return errorAttributes;
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}