package mins.study.oopp.ticket.discount.condition;

import mins.study.oopp.theater.ScreeningSchedule;

import java.time.LocalTime;

/**
 * 조조 할인
 *
 */
public class MorningDiscountCondition extends DiscountCondition {

    @Override
    public boolean isSatisfied(ScreeningSchedule screeningSchedule) {
        return screeningSchedule.getStartTme().toLocalTime().isBefore(LocalTime.of(10, 0));
    }

    @Override
    public int discountPrice() {
        return 5_000;
    }
}
