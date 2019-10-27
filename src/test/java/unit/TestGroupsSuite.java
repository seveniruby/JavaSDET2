package unit;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(SlowGroup.class)
@Categories.ExcludeCategory(FastGroup.class)
@Suite.SuiteClasses({
        TestGroups.class
})

public class TestGroupsSuite {
}
