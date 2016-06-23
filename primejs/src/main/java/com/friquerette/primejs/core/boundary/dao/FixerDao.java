package com.friquerette.primejs.core.boundary.dao;

import com.friquerette.primejs.core.boundary.entity.CurrencyEnum;
import com.friquerette.primejs.core.boundary.entity.Fixer;

public interface FixerDao {

	public Fixer latest();

	public Fixer latest(CurrencyEnum origin, CurrencyEnum... source);

}
