package laoride.lao_ride.product.domain;

import jakarta.persistence.*;
import laoride.lao_ride.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product_model") // 테이블명을 명확히 지정
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA는 기본 생성자가 필요하므로 NoArgsConstructor 추가
public class ProductModel extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob // 대용량 텍스트
    @Column(columnDefinition = "TEXT") // DB 타입을 TEXT로 명시
    private String description;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal dailyRate; // 일일 요금

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyRate; // 월별 요금

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal deposit; // 보증금

    @Lob
    @Column(columnDefinition = "TEXT", name = "included_items")
    private String includedItems;

    @Lob
    @Column(columnDefinition = "TEXT", name = "not_included_items")
    private String notIncludedItems;

    @Lob
    @Column(columnDefinition = "TEXT", name = "usage_guide")
    private String usageGuide;

    @Lob
    @Column(columnDefinition = "TEXT", name = "cancellation_policy")
    private String cancellationPolicy;

    @Column(nullable = false)
    private boolean isActive; // 모델 판매 여부

    // --- 향후 확장을 위한 필드 ---
    private Integer maxRange; // 최대 운행 거리 (km)
    private String genderType; // 'MALE', 'FEMALE', 'UNISEX'


    @Builder
    public ProductModel(
            String name, String description, String thumbnailUrl,
            BigDecimal dailyRate, BigDecimal monthlyRate, BigDecimal deposit,
            Integer maxRange, String genderType,
            String includedItems, String notIncludedItems, String usageGuide, String cancellationPolicy,
            boolean isActive
    ) {
        this.name = name;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;

        this.dailyRate = dailyRate;
        this.monthlyRate = monthlyRate;
        this.deposit = deposit;

        this.maxRange = maxRange;
        this.genderType = genderType;

        this.includedItems = includedItems;
        this.notIncludedItems = notIncludedItems;
        this.usageGuide = usageGuide;
        this.cancellationPolicy = cancellationPolicy;
        this.isActive = isActive;

    }

    /**
     * 상품의 상세 정보를 업데이트하는 비즈니스 메서드
     */
    public void updateDetails(
            String name, String description,
            BigDecimal dailyRate, BigDecimal monthlyRate, BigDecimal deposit,
            String includedItems, String notIncludedItems,
            String usageGuide, String cancellationPolicy, boolean isActive
    ) {
        this.name = name;
        this.description = description;
        this.dailyRate = dailyRate;
        this.monthlyRate = monthlyRate;
        this.deposit = deposit;
        this.includedItems = includedItems;
        this.notIncludedItems = notIncludedItems;
        this.usageGuide = usageGuide;
        this.cancellationPolicy = cancellationPolicy;
        this.isActive = isActive;
    }

    // 대표이미지 설정
    public void updateThumbnailUrl(String imageUrl) {
        this.thumbnailUrl = imageUrl;
    }

}
