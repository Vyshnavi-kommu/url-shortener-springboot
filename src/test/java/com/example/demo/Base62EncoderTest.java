package com.example.demo;

import com.example.demo.Base62Encoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base62EncoderTest {

    @Test
    void testEncode() {
        String result = Base62Encoder.encode(125);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testDifferentInputs() {
        String val1 = Base62Encoder.encode(1);
        String val2 = Base62Encoder.encode(2);

        assertNotEquals(val1, val2);
    }
    @Test
    void testDecode() {
        long original = 125;
        String encoded = Base62Encoder.encode(original);
        long decoded = Base62Encoder.decode(encoded);

        assertEquals(original, decoded);
    }

    @Test
    void testZero() {
        assertEquals("0", Base62Encoder.encode(0));
    }
}