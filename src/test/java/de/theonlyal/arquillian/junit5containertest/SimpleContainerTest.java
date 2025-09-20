package de.theonlyal.arquillian.junit5containertest;

import org.arquillian.ape.api.UsingDataSet;
import org.arquillian.ape.rdbms.CreateSchema;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ArquillianExtension.class)
@CreateSchema
public class SimpleContainerTest {

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class)
				.addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").resolve("org.postgresql:postgresql")
						.withTransitivity().asFile())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource("test-persistence.xml", "persistence.xml");
	}

	@Test
	@UsingDataSet
	public void testSeeding() {
	}
}