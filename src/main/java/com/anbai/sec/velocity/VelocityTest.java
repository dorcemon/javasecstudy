package com.anbai.sec.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;

public class VelocityTest {
    public static void main(String[] args) throws Exception {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(VelocityEngine.RESOURCE_LOADER,"file");
        velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH,"src/main/resources");
        velocityEngine.init();

        VelocityContext context = new VelocityContext();
        context.put("name","Rai4over");
        context.put("project","Velocity");

        Template template = velocityEngine.getTemplate("test.vm");
        StringWriter sw = new StringWriter();
        template.merge(context,sw);
        System.out.println("final output:" + sw);
    }
}
