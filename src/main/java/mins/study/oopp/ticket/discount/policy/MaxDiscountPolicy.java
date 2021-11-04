package mins.study.oopp.ticket.discount.policy;

import mins.study.oopp.theater.ScreeningSchedule;
import mins.study.oopp.ticket.discount.condition.DiscountCondition;

/**
 * 최대 할인 정책 적용
 *
 */
public class MaxDiscountPolicy extends DiscountPolicy {

    public MaxDiscountPolicy(DiscountCondition... discountConditions) {
        super(discountConditions);
    }

    @Override
    protected int getDiscountPrice(ScreeningSchedule screeningSchedule) {
        return super.discountConditions.stream()
                .filter(discountCondition -> discountCondition.isSatisfied(screeningSchedule))
                .mapToInt(DiscountCondition::discountPrice).max()
                .orElse(0);
    }
}
