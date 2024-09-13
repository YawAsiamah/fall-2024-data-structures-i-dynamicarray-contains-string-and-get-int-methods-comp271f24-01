public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private String[] foundation;

    public DynamicArray(int size) {
        foundation = new String[size > 0 ? size : DEFAULT_SIZE];
    }

    public DynamicArray(String[] data) {
        foundation = data != null ? data : new String[DEFAULT_SIZE];
    }

    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    public boolean contains(String target) {
        for (String item : foundation) {
            if (target == null && item == null) {
                return true;
            }
            if (target != null && target.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public String get(int index) {
        if (index < 0 || index >= foundation.length) {
            return null;
        }
        return foundation[index];
    }

    public static void main(String[] args) {
        String[] testData = {"Java", "Python", "C"};
        DynamicArray array = new DynamicArray(testData);
        DynamicArray emptyArray = new DynamicArray(null);

        System.out.printf("\nTest for contains(null): %s", !array.contains(null) ? "Pass" : "Fail");
        System.out.printf("\nTest for contains on null foundation: %s", !emptyArray.contains("Java") ? "Pass" : "Fail");
        System.out.printf("\nTest for contains (existing): %s", array.contains("Python") ? "Pass" : "Fail");
        System.out.printf("\nTest for contains (non existing): %s", !array.contains("COBOL") ? "Pass" : "Fail");

        System.out.printf("\nTest for get(-1): %s", array.get(-1) == null ? "Pass" : "Fail");
        System.out.printf("\nTest for get(0): %s", "Java".equals(array.get(0)) ? "Pass" : "Fail");
        System.out.printf("\nTest for get(out of bounds): %s\n", array.get(3) == null ? "Pass" : "Fail");
    }
}


/**CLASS DynamicArray
    CONSTANT DEFAULT_SIZE = 4
    PRIVATE ARRAY foundation

    // Step 1: Constructor with size
    METHOD DynamicArray(size)
        IF size > 0 THEN
            SET foundation TO new ARRAY of size
        ELSE
            SET foundation TO new ARRAY of DEFAULT_SIZE
        END IF
    END METHOD

    // Step 2: Constructor with data
    METHOD DynamicArray(data)
        IF data IS NOT NULL THEN
            SET foundation TO data
        ELSE
            SET foundation TO new ARRAY of DEFAULT_SIZE
        END IF
    END METHOD

    // Step 3: Default constructor
    METHOD DynamicArray()
        CALL DynamicArray(DEFAULT_SIZE)
    END METHOD

    // Step 4: Check if array contains target
    METHOD contains(target)
        FOR EACH item IN foundation
            IF target EQUALS item THEN
                RETURN TRUE
            END IF
        END FOR
        RETURN FALSE
    END METHOD

    // Step 5: Get item at index
    METHOD get(index)
        IF index < 0 OR index >= LENGTH of foundation THEN
            RETURN NULL
        ELSE
            RETURN foundation[index]
        END IF
    END METHOD

    // Step 6: Main method for testing
    METHOD main()
        // Create test data
        SET testData TO {"Java", "Python", "C"}
        
        // Create DynamicArray objects
        CREATE array WITH testData
        CREATE emptyArray WITH NULL

        // Test contains method
        PRINT "Test contains(null): " + NOT array.contains(NULL)
        PRINT "Test contains(null foundation): " + NOT emptyArray.contains("Java")
        PRINT "Test contains(existing): " + array.contains("Python")
        PRINT "Test contains(non-existing): " + NOT array.contains("COBOL")

        // Test get method
        PRINT "Test get(-1): " + (array.get(-1) IS NULL)
        PRINT "Test get(0): " + (array.get(0) EQUALS "Java")
        PRINT "Test get(out of bounds): " + (array.get(3) IS NULL)
    END METHOD
END CLASS **/
