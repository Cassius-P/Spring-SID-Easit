package fr.easit.easit.models.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.TypeDef;
import org.json.JSONObject;
@TypeDef(name = "json", typeClass = JsonType.class)
public class ServiceSettings {
}
