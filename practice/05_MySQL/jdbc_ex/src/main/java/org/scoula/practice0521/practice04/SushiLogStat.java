package org.scoula.practice0521.practice04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SushiLogStat {
    private String plateColor;
    private String count;

    @Override
    public String toString() {
        return "최애 접시는 " + plateColor + " (" + count + "회)";
    }
}
