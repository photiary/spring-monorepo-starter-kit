package com.funa.batchapp.example.entity;

import com.funa.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "batch_biz_example_processed_data")
@Getter
@Setter
@NoArgsConstructor
public class ExampleProcessedData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "processed_amount", nullable = false)
    private Integer processedAmount;

    @OneToOne
    @JoinColumn(name = "raw_data_id", nullable = false)
    private ExampleRawData rawData;

    public ExampleProcessedData(ExampleRawData rawData, Integer processedAmount) {
        this.rawData = rawData;
        this.processedAmount = processedAmount;
    }
}
