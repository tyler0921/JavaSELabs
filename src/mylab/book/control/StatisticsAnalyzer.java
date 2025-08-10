package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.*;

public class StatisticsAnalyzer {

    // Ÿ�Ժ� ��� ���� ���
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> priceSumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            priceSumMap.put(type, priceSumMap.getOrDefault(type, 0.0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averagePriceMap = new HashMap<>();
        for (String type : priceSumMap.keySet()) {
            averagePriceMap.put(type, priceSumMap.get(type) / countMap.get(type));
        }
        return averagePriceMap;
    }

    // ���ǹ� ���� ���� ���
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();
        int total = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distributionMap = new HashMap<>();
        for (String type : countMap.keySet()) {
            distributionMap.put(type, (double) countMap.get(type) / total * 100);
        }
        return distributionMap;
    }

    // Ư�� ���� ���ǹ� ���� ���
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return (double) count / publications.length * 100;
    }

    // ���ǹ� Ÿ�� Ȯ�� ���� �޼���
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "�Ҽ�";
        if (pub instanceof Magazine) return "����";
        if (pub instanceof ReferenceBook) return "����";
        return "��Ÿ";
    }

    // ��� ���� ���
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("===== ���ǹ� ��� �м� =====");

        System.out.println("1. Ÿ�Ժ� ��� ����:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + df.format(entry.getValue()) + "��");
        }

        System.out.println("\n2. ���ǹ� ���� ����:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println("   - " + entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }

        System.out.println("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: "
                + df.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
        System.out.println("=============================");
    }
}