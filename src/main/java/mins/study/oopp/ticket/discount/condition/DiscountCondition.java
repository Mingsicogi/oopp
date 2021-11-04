package mins.study.oopp.ticket.discount.condition;

import mins.study.oopp.theater.ScreeningSchedule;

public abstract class DiscountCondition {

    abstract public boolean isSatisfied(ScreeningSchedule screeningSchedule);

    abstract public int discountPrice();
}
