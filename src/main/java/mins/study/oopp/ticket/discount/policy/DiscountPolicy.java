package mins.study.oopp.ticket.discount.policy;

import mins.study.oopp.theater.ScreeningSchedule;
import mins.study.oopp.ticket.discount.condition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {

    protected final List<DiscountCondition> discountConditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition... discountConditions) {
        this.discountConditions.addAll(Arrays.asList(discountConditions));
    }

    public Integer calculateFinalPrice(ScreeningSchedule screeningSchedule) {
        return screeningSchedule.getScreening().getPrice() - this.getDiscountPrice(screeningSchedule);
    }

    abstract protected int getDiscountPrice(ScreeningSchedule screeningSchedule);
}
