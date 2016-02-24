package com.epam.spring.club.DAO.interfaces;

public interface DiscountStatisticsRepository {
    int getDiscountCountByClient(String clientId);

    int getTotalDiscountsCount();

    void addDiscountCountByClient(String clientId);

    void addTotalDiscountsCount();
}
