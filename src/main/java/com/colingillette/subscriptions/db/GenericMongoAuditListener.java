package com.colingillette.subscriptions.db;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;

import java.time.LocalDateTime;

public class GenericMongoAuditListener extends AbstractMongoEventListener<Object> {

    @Override
    public void onAfterSave(AfterSaveEvent<Object> event) {
        Object object = event.getSource();
        System.out.println(LocalDateTime.now() + "Saved document " + object);
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Object> event) {
        Object object = event.getSource();
        System.out.println(LocalDateTime.now() + "Deleted document " + object);
    }
}
