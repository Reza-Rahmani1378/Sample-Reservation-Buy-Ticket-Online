package ir.maktab56.airline.service.impl;


import ir.maktab56.airline.base.service.impl.BaseServiceImpl;
import ir.maktab56.airline.domain.AirLineOperator;
import ir.maktab56.airline.repository.AirLineOperatorRepository;
import ir.maktab56.airline.service.AirLineOperatorService;

public class AirLineOperatorServiceImpl extends BaseServiceImpl<AirLineOperator, Long, AirLineOperatorRepository> implements
        AirLineOperatorService {

    public AirLineOperatorServiceImpl(AirLineOperatorRepository repository) {
        super(repository);
    }

}
