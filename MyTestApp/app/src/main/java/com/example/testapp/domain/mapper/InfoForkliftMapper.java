package com.example.testapp.domain.mapper;

import com.example.testapp.domain.print.InfoForkliftPrint;
import com.sample.core.dto.InfoForklift;

public class InfoForkliftMapper extends Mapper<InfoForklift, InfoForkliftPrint> {
    @Override
    protected InfoForkliftPrint mapImp(InfoForklift item) {
        return new InfoForkliftPrint(
                item.getNameForklift()
        );
    }
}
