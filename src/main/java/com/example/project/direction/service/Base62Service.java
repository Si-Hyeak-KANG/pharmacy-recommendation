package com.example.project.direction.service;

import io.seruco.encoding.base62.Base62;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Base62Service {

    /**
     * URL shorten service
     * 요청 URL에 대응하는 Unique한 식별자가 필요
     * 1) DB에 길안내 정보(위경도와 약국정보)를 저장하고, pk를 사용하는 방법
     * ex> http://host:port/10000000000 -> id 타입이 Long 이다보니 10진수 큼
     * 2) base64 사용
     * -> "=" 등은 URL 예약어이기 때문에 문제 발생 (62보다 3개[+,/,=] 더 사용)
     * 3) 따라서 영어와 숫자 혼용 base62 사용
     */
    private static final Base62 base62Instance = Base62.createInstance();

    public String encodeDirectionId(Long directionId) {
        return new String(base62Instance.encode(String.valueOf(directionId).getBytes()));
    }

    public Long decodeDirectionId(String encodedDirectionId) {
        String resultDirectionId = new String(base62Instance.decode(String.valueOf(encodedDirectionId).getBytes()));
        return Long.valueOf(resultDirectionId);
    }
}
