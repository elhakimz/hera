package org.hakeem.hera.web.screens.ranktype;

import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.hr.RankType;
import org.hibernate.validator.Incubating;

import javax.inject.Inject;

@UiController("hera_Rank.browse")
@UiDescriptor("rank-type-browse.xml")
@LookupComponent("rankTypesTable")
@LoadDataBeforeShow
public class RankTypeBrowse extends StandardLookup<RankType> {

    @Inject
    private DataContext dataContext;

    @Inject
    private CollectionContainer<RankType> rankTypesDc;
    @Inject
    private Table<RankType> rankTypesTable;

    @Subscribe("rankTypesTable.create")
    public void onRankTypesTableCreate(Action.ActionPerformedEvent event) {
        createRankType();
    }

    private void createRankType(){
        RankType rt=dataContext.create(RankType.class);
        rt.setName("");
        rt.setDescription("");
        rankTypesDc.getMutableItems().add(rt);
        rankTypesTable.setSelected(rt);
    }

    @Subscribe(id = "rankTypesDc", target = Target.DATA_CONTAINER)
    public void onRankTypesDcCollectionChange(CollectionContainer.CollectionChangeEvent<RankType> event) {
        dataContext.commit();
    }

}