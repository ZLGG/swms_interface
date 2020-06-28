package com.mk.business.budget.param;

import com.mk.business.budget.model.Budget;
import com.mk.business.budget.model.Budgetmoney;
import java.util.List;

/**
 * Description:支出预算资金明细
 * Created by zhangnengwei on 2020-4-7 15:02
 */
public class BudgetRequestParam extends Budget {
    List<Budgetmoney> budgetmoneyList;

    public List<Budgetmoney> getBudgetmoneyList() {
        return budgetmoneyList;
    }

    public void setBudgetmoneyList(List<Budgetmoney> budgetmoneyList) {
        this.budgetmoneyList = budgetmoneyList;
    }
}
