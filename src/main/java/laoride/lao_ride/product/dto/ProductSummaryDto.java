package laoride.lao_ride.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // 모든 필드를 받는 생성자 추가
public class ProductSummaryDto {

    private String name;
    private String status;
    private String imageUrl;

}
