package org.openbravo.functional.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openbravo.functional.analytics.MovieAnalyticsShould;
import org.openbravo.functional.custom.MethodReferencesTestsShould;
import org.openbravo.functional.finder.MovieFinderShould;
import org.openbravo.functional.finder.UserFinderShould;
import org.openbravo.functional.printer.UserPrinterShould;

@RunWith(Suite.class)

@Suite.SuiteClasses({ UserFinderShould.class, //
    MovieFinderShould.class, //
    MovieAnalyticsShould.class, //
    MethodReferencesTestsShould.class, //
    UserPrinterShould.class })

public class AllTests {
}
