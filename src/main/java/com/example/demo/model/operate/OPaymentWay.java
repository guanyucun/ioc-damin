package com.example.demo.model.operate;/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

import lombok.Getter;
import lombok.Setter;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.PreDataProxy;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Getter
@Setter
@PreDataProxy(OPaymentWayDataProxy.class)
@Erupt(name = "各支付方式收款")
@Table(name = "o_payment_way",
                uniqueConstraints = {@UniqueConstraint(name = "uk_year", columnNames={"year"}),
                @UniqueConstraint(name = "uk_obsTime", columnNames={"obsTime"}),})
@Entity
public class OPaymentWay extends BaseModel {

        @EruptField(
                views = @View(
                        title = "年/月类型",
                        desc = "年/月只能选择一个"
                ),
                edit = @Edit(
                        title = "年/月类型",
                        desc = "年/月只能选择一个",
                        type = EditType.CHOICE, search = @Search, notNull = true,
                        choiceType = @ChoiceType(vl = {@VL(value = "YEAR", label = "年"), @VL(value = "MONTH", label = "月")})
                )
        )
        private String type;

        @EruptField(
                views = @View(
                        title = "年", sortable = true,
                        desc = "年/月只能选择一个"
                ),
                edit = @Edit(
                        title = "年",
                        desc = "年/月只能选择一个",
                        type = EditType.DATE, search = @Search,
                        dateType = @DateType(type = DateType.Type.YEAR)
                )
        )
        private String year;

        @EruptField(
                views = @View(
                        title = "月", sortable = true,
                        desc = "年/月只能选择一个"
                ),
                edit = @Edit(
                        title = "月",
                        desc = "年/月只能选择一个",
                        type = EditType.DATE, search = @Search,
                        dateType = @DateType(type = DateType.Type.MONTH)
                )
        )
        private String obsTime;

        @EruptField(
                views = @View(
                        title = "银行转账（万）"
                ),
                edit = @Edit(
                        title = "银行转账（万）",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer bankTransfer;

        @EruptField(
                views = @View(
                        title = "票据（万）"
                ),
                edit = @Edit(
                        title = "票据（万）",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer bill;

        @EruptField(
                views = @View(
                        title = "第三方平台（万）"
                ),
                edit = @Edit(
                        title = "第三方平台（万）",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer other;

        @EruptField(
                views = @View(
                        title = "现金（万）"
                ),
                edit = @Edit(
                        title = "现金（万）",
                        type = EditType.NUMBER, notNull = true,
                        numberType = @NumberType
                )
        )
        private Integer cash;

}