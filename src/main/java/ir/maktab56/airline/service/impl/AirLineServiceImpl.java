package ir.maktab56.airline.service.impl;


import ir.maktab56.airline.base.service.impl.BaseServiceImpl;
import ir.maktab56.airline.domain.AirLine;
import ir.maktab56.airline.repository.AirLineRepository;
import ir.maktab56.airline.service.AirLineService;

public class AirLineServiceImpl extends BaseServiceImpl<AirLine, Long, AirLineRepository> implements
        AirLineService {

    public AirLineServiceImpl(AirLineRepository repository) {
        super(repository);
    }

}
