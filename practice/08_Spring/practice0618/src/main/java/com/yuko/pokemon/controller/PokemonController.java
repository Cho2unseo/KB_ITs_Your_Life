package com.yuko.pokemon.controller;

import com.yuko.pokemon.dto.PokemonListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/pokemon")
@RequiredArgsConstructor
@Log4j2
@Api(tags = "포켓몬 도감 API")
public class PokemonController {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://pokeapi.co/api/v2/pokemon?limit=20";

    @ApiOperation(value = "포켓몬 목록 상세 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = PokemonListResponse.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping("/list")
    public ResponseEntity<List<PokemonListResponse>> getPokemon() {
        List<PokemonListResponse> list = new ArrayList<>();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        List<Map<String, String>> results = (List<Map<String, String>>) response.get("result");
        for (Map<String, String> result: results) {
            String detailUrl = result.get("url");
            try {
                PokemonListResponse detail = restTemplate.getForObject(detailUrl, PokemonListResponse.class);
                list.add(detail);
            } catch (Exception e) {
                log.error("포켓몬 상세 정보 호출 실패: {}", e);
            }
        }
        return ResponseEntity.ok(list);
    }
}
