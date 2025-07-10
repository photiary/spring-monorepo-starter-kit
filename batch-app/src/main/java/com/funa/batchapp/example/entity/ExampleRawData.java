package com.funa.batchapp.example.entity;

import com.funa.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "batch_biz_example_raw_data")
@Getter
@Setter
@NoArgsConstructor
public class ExampleRawData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "raw_amount", nullable = false)
    private Integer rawAmount;

    @OneToOne(mappedBy = "rawData", cascade = CascadeType.ALL)
    private ExampleProcessedData processedData;

    public ExampleRawData(Integer rawAmount) {
        this.rawAmount = rawAmount;
    }
}
