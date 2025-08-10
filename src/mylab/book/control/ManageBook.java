package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {

    public static void main(String[] args) {
        // 출판물 배열 생성 및 초기화
        Publication[] publications = {
            new Magazine("마이크로소프트웨어", "2007-10-01", 328, 9900, "월간"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "월간"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
            new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
            new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };

        // 출판물 정보 출력
        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i + 1) + ". " + publications[i].toString());
        }
        System.out.println();

        // 가격 변경 및 출력 (7번째 도서로 변경)
        System.out.println("==== 가격 변경 ====");
        Publication bookToModify = publications[6];
        int originalPrice = bookToModify.getPrice();
        System.out.println(bookToModify.getTitle() + " 변경 전 가격: " + originalPrice + "원");
        
        modifyPrice(bookToModify);
        
        System.out.println(bookToModify.getTitle() + " 변경 후 가격: " + bookToModify.getPrice() + "원");
        System.out.println("차액: " + (originalPrice - bookToModify.getPrice()) + "원\n");

        // 통계 분석 실행
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(publications);
    }

    // 가격 변경 메서드
    public static void modifyPrice(Publication publication) {
        int currentPrice = publication.getPrice();
        // instanceof로 실제 객체 타입 확인 후 차별적 할인 적용
        if (publication instanceof Magazine) {
            publication.setPrice((int) (currentPrice * 0.6)); // 40% 할인
        } else if (publication instanceof Novel) {
            publication.setPrice((int) (currentPrice * 0.8)); // 20% 할인
        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int) (currentPrice * 0.9)); // 10% 할인
        }
    }
}