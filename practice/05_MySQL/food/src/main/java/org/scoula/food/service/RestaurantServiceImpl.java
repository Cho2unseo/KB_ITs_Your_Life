package org.scoula.food.service;

import lombok.RequiredArgsConstructor;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    final RestaurantDao dao;

    @Override
    public void printRestaurantWithReviews() {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 맛집 ID를 입력하세요: ");
        long id = Long.parseLong(sc.nextLine());
        System.out.println();
        RestaurantVO restaurant = dao.getRestaurantWithReviews(id).orElseThrow(NoSuchElementException::new);
        System.out.println("[맛집 정보]");
        System.out.println("이름: " + restaurant.getName());
        System.out.println("카테고리: " + restaurant.getCategory());
        System.out.println("주소: " + restaurant.getAddress());
        System.out.println("설명: " + restaurant.getDescription());
        System.out.println();
        if (restaurant.getReviews().isEmpty()) System.out.println("등록된 리뷰가 없습니다.");
        else {
            System.out.println("[리뷰 목록]");
            for (RestaurantReviewVO review: restaurant.getReviews()) {
                System.out.println("- " + review.getWriter() + " (" + review.getScore() + "점): " + review.getContent());
            }
        }
    }

    @Override
    public void printAllRestaurantAvgScore() {
        System.out.println("📊 맛집 평균 평점 순위");
        List<RestaurantVO> list = dao.getAllRestaurantWithScoreAvg();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAverageScore() == null) {
                System.out.println((i + 1) + ". " + list.get(i).getName() + " (리뷰 없음)" + " - " + list.get(i).getAddress());
            }
            else {
                System.out.println((i + 1) + ". " + list.get(i).getName() + " (" + list.get(i).getAverageScore() + "점) - " + list.get(i).getAddress());
            }
        }
    }
}
