plugins {
  id("java")
  id("org.jetbrains.intellij") version "1.15.0"
}

group "com.andreycizov.partialnav"
version = "2.22"

repositories {
  mavenCentral()
}

// Configure Gradle IntelliJ Plugin - read more: https://github.com/JetBrains/gradle-intellij-plugin
intellij {
  version.set("LATEST-EAP-SNAPSHOT")
  type.set("IC") // Target IDE Platform

  plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
  // Set the JVM compatibility versions
  withType<JavaCompile> {
    sourceCompatibility = "11"
    targetCompatibility = "11"
  }

  patchPluginXml {
    sinceBuild.set("232")
    untilBuild.set("232.*")

    // TODO Not sure this works! But leaving to retain old code
    changeNotes.value("""
      <ul>
      <li>Version 2.2: Converted to Kotlin Gradle and fixed issues to work with 2022.2</li>
      <li>Version 1.2: honour "Prefer moving caret line to minimize editor scrolling" and support navigation by a fixed number of lines</li>
      <li>Version 1.1: support partial page up/down with selection, set default keyboard shortcuts</li>
      <li>Version 1.0: build the plugin for the first time</li>
      </ul>
      """)
  }

  signPlugin {
    certificateChain.set("-----BEGIN CERTIFICATE-----\n" +
            "MIIFZTCCA02gAwIBAgIUFMsgiWmyvuixIs6k2PErWyNCaK8wDQYJKoZIhvcNAQEL\n" +
            "BQAwQjELMAkGA1UEBhMCWFgxFTATBgNVBAcMDERlZmF1bHQgQ2l0eTEcMBoGA1UE\n" +
            "CgwTRGVmYXVsdCBDb21wYW55IEx0ZDAeFw0yMjEyMjExNTQyMzBaFw0yMzEyMjEx\n" +
            "NTQyMzBaMEIxCzAJBgNVBAYTAlhYMRUwEwYDVQQHDAxEZWZhdWx0IENpdHkxHDAa\n" +
            "BgNVBAoME0RlZmF1bHQgQ29tcGFueSBMdGQwggIiMA0GCSqGSIb3DQEBAQUAA4IC\n" +
            "DwAwggIKAoICAQDGme1yOpuGyufaY70skwVKqRGntFduY/Nx7QVP3SyYDXrgxAFh\n" +
            "nJtpFGixsckz2/eIbIrpeH534P/f+5PhUCCumOl44TVgCDh26TeYqywkZt1CQTaG\n" +
            "oOPQEJstOdzw03e8BZtYgcZXYnDoF6BGxtIYO26kPp49l70kPWuAsqByk+K8VdHT\n" +
            "4r/nGHVyNdFYfS1az6TNf7NxTKx5szl+KCBCw5CUzR7SicnccG988QLxw/n1aTBR\n" +
            "+Fpj/JblyMtTORNns0HbBK8AU9lVCiPfidQF9HkNAMan1LWTCTCBBvAhoITu7YL6\n" +
            "GzdWZyeVwdVLg4V80GTu601jW+SQmhbqI0KOdKesyvJibmDRGHVy69m5SOZ8j9H7\n" +
            "DLRzEOHS1+dpKuZk8fw6MAgsXl4dLe1a95zYHciVgDtyGo/lag/SPGgV449n9DFF\n" +
            "oP5WowRaqbPtH1h6EUm5wg4Nua9ZVmeSdnx8u2sXi33ZT1b5B1egyu7WxNtvVNYr\n" +
            "kV+1pV5mcgpxoNNTnp0lODuryYOn7aHzK/1+ndWezZYwUOzKezuiTmySh5mQFVtF\n" +
            "PlLMY6wXAWD6caHDYebJsVBPN2D1Fo1t9eRNIw4Y3nLiBvpr7KssFGSKnQfabEW8\n" +
            "Z3UDuQp/uaapfrBdZ+e1Y+0COzqsMvLTiwxqapvFsqgAU8KykitPlDcdqQIDAQAB\n" +
            "o1MwUTAdBgNVHQ4EFgQUrSZVqgbvVzCcOP+wgCUuhE3nt8MwHwYDVR0jBBgwFoAU\n" +
            "rSZVqgbvVzCcOP+wgCUuhE3nt8MwDwYDVR0TAQH/BAUwAwEB/zANBgkqhkiG9w0B\n" +
            "AQsFAAOCAgEAwivDlYhXrk81lYnROIJuk1zWnwisDhwD7G79kldIo13jlZvzT2wY\n" +
            "75AngLwEV7kaNpYK0iPnIgpRBGNJ6nATTdYrlWPefQ+zz1BAXWRLnczceJF3/hnX\n" +
            "7WWdV8/T+hzFKEOsl+3AYM0X1zLOGCu3XluBaDMdWg4rlRxwSTJnN4/H/Q0gVxtX\n" +
            "xDCwH5CuyiLTmmWYMXeL8QWxOC/nwjM4IFKgCY23yT6CeiBPPVStkk3eSbCpwRVO\n" +
            "XkvxAZj4HaGgPBWqFDxhX248cksDteUbz9nLM1dmqHV3+7gydE5waO1fP7g0+Pld\n" +
            "1eWf76+pV3PESQMfAMDragMl3UeVxDDu/T8lshjx5pGG4S41U+zhQxAdB2ZKmMUt\n" +
            "d2hubWRY35RI/KLm7FcS1tl1TgiVC71G0opUZu6VI9I/olxU6c5Cl7ocuwzDsH3V\n" +
            "wRy+u8z4znOChslr1pAwl3XVRiM6h0ErIdOWA6qACwLSiw5bguvM0sp7lZE8Ms8u\n" +
            "zmMANo/3FG7BmF/vmFmnFEIdjXzQGpu/QrqMps+zYNKVadHTZOO6WTUal9+eWyjt\n" +
            "YQQU0XsugbqJGzeLNdU35SDeHN1wE/pvGZ+4YkG8OMbO6QSXo6e5IWVjFjIS2drt\n" +
            "ViULyydO2nBfQZhofwGqYIbCD/1Mss++GikTNsQMN1vWLXBjhwCPh54=\n" +
            "-----END CERTIFICATE-----".trimIndent())
    privateKey.set("-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIJKgIBAAKCAgEAxpntcjqbhsrn2mO9LJMFSqkRp7RXbmPzce0FT90smA164MQB\n" +
            "YZybaRRosbHJM9v3iGyK6Xh+d+D/3/uT4VAgrpjpeOE1YAg4duk3mKssJGbdQkE2\n" +
            "hqDj0BCbLTnc8NN3vAWbWIHGV2Jw6BegRsbSGDtupD6ePZe9JD1rgLKgcpPivFXR\n" +
            "0+K/5xh1cjXRWH0tWs+kzX+zcUysebM5figgQsOQlM0e0onJ3HBvfPEC8cP59Wkw\n" +
            "UfhaY/yW5cjLUzkTZ7NB2wSvAFPZVQoj34nUBfR5DQDGp9S1kwkwgQbwIaCE7u2C\n" +
            "+hs3VmcnlcHVS4OFfNBk7utNY1vkkJoW6iNCjnSnrMryYm5g0Rh1cuvZuUjmfI/R\n" +
            "+wy0cxDh0tfnaSrmZPH8OjAILF5eHS3tWvec2B3IlYA7chqP5WoP0jxoFeOPZ/Qx\n" +
            "RaD+VqMEWqmz7R9YehFJucIODbmvWVZnknZ8fLtrF4t92U9W+QdXoMru1sTbb1TW\n" +
            "K5FftaVeZnIKcaDTU56dJTg7q8mDp+2h8yv9fp3Vns2WMFDsyns7ok5skoeZkBVb\n" +
            "RT5SzGOsFwFg+nGhw2HmybFQTzdg9RaNbfXkTSMOGN5y4gb6a+yrLBRkip0H2mxF\n" +
            "vGd1A7kKf7mmqX6wXWfntWPtAjs6rDLy04sMamqbxbKoAFPCspIrT5Q3HakCAwEA\n" +
            "AQKCAgBOCDDpjumI3rSWdFXh66pKmX9cW1l3AEKo4q4RoR9iZvl+0sSQK85MTT6N\n" +
            "gwNBIw5xReSWs0dNptQil2CVSLxunZouap5kKxa0chHsJGVlsB0DaUgZQaIBIGU4\n" +
            "MeIDpbMH51QQRH0/3GfsaUwKQxhNeRyR4CCgprwkPxW8LXMpUb3mrfmRvSgVjuCm\n" +
            "jUrB7/0gDzH7pE9HFw81ihvu26lBUkG+lZGku4ra2DqV5sR3Zb8Sk8/uhRxO6PIJ\n" +
            "OwnYmzZqql4XxhFUmZ1s8l0B+c+av2HIoCNt0f+91ACA0c8MB1vz3NJ3nrXxdvpw\n" +
            "twYtc3HBhsgBr+ZqQbLetgyG1m/Rg6UG1U9ZWNwJRQxTsHFpE+NVVPBwBcjeichf\n" +
            "Bpkr9cl/UeElYMxATWy+aKCC7nkpBfhfnAzT2kcBfMmJPbqbN+CgrekC/8/j3WU/\n" +
            "nzBW+IiKF9trVnYwhhHPH6vlYLN/dSFOPhlwWVJdCvodCXSUjfoahXSgjRQ7AJmU\n" +
            "eyj1shN+iku/AZcpWq8ydnvVbJ1P411og+kZJJ93sXTm3ZOrGyi4m1T0ysIWZXqz\n" +
            "ebcuKt6yULFbSC3iR+yt1m/18+SaUCUEPU9XQfok9M1aoWkYpHJQShPh5dhH7aYX\n" +
            "+DYz0Ifz50Zvp/GdpBkz7ybXHiohWA+kO2IimUsQDRQwo/Gs4QKCAQEA8NwrRmcW\n" +
            "jANpShtr5AWEQR4iMLCPAjYBzbBchX2a36qv1MIPp6D6J1tP74H8N4gj8SRQcAQB\n" +
            "FehemU53ir5jz8ZC51u8goSVC/0Oq11eM+YPhy3ju06+696X3T0UUwkkz1kY/ZK1\n" +
            "o6CRsJSwKa7+7X/bpNOClDai97JnXMPx3JeE9TY7hyGF3b7q5mQbJzgrXYPYz1ut\n" +
            "wwvQ9ahMmre9ZN1gosvyi+9FjeBn2bzUDQe4RWNGClgmypM1NjIITOK36rhgs27z\n" +
            "gDqcQnnGKWhOFN9nFlizvXYz6it1StTUatUKd8c73LuTn/cua6Zc6x02yKoP1/yu\n" +
            "rmpFKPPb8mbmlQKCAQEA0xW/A5kMnOXnht/gNdkptCsfQVjtXGzIXZbmVf2I3v4t\n" +
            "S9RZoyuDzNKbFYKJ7W8oqRk1c1nwuAjl//LS+gAjvxVkdAhUM2yJcjF1qjs3hegj\n" +
            "3p5RzWNbU/dRYBUv5BfRcZ7Bf4GSysNxkMo3mS401K/RfWU+DvLKS1KCi6CkcPg3\n" +
            "lsnH0SH+IriUAwX43JlMUzc66jCY9zcqn/R7edH5mAJ5z625Qjyz4CTfP7auu81Z\n" +
            "1hHcRw9HIIVlVfM0JtfimWSRjRCmyyJxpXAOgKGWSl7YLkvg3CjeGuK5FiM3GI0y\n" +
            "iRtqQPjJwVoeUHebnjEuFUxlZTa46BPqVmyfeU65xQKCAQEAsbtFk6XuVVMPFsg1\n" +
            "TQVlGkgKIrOmU5NWsVk6bKbK6dEh/nVU5/U5omEXEz1vx+qF2yNY18+cnXXimG32\n" +
            "eEMVk/RQ2jgvWoBLG5WYhYtYQCO7wZxzN3xcFeEjXvX7UWql5vtwHW1s61lJKGwP\n" +
            "sjKXmtmGUpJhAM1wZCcZbrKIfqawTeG++3AZQA/pdijYgJBKL69jBWA5UHwfraaL\n" +
            "IIAFGbDh5j9osynUwWSePWXBc/wGVe1zeZ6iwUjvMxaoWVPTMzjq4n004aJePA9v\n" +
            "0o5NT8mqYCsENwJKPLnky1tRg6PBHbG+0pr3zEqxzm3skvHzww76sf6bR8jTT+zi\n" +
            "mHSmIQKCAQEAgmB5JeC/cJ10HtNiqf/jCVxlJriliyPJsjzFMjGx+4HlOmQDpYv4\n" +
            "EWe30FZbmOLCq4ddg0z3KMSeQzOZaj7x1VGCRUTrtQOB9Z1k/usqhTP4C8Wf4wtO\n" +
            "WpN0mLMdbHXlsJcNDxNaNpD3MSYlpyBqE0AxVZFV/mep2VIyPcnQJ9K4ixNArwSe\n" +
            "8pUtHpzutFqfUPrZEdNId9GEK14XcgvmbSSCVmsH9UiHFZfQqIrObEMPDPDlLKLc\n" +
            "HNMn3ymjeaZ4WKRMXmP9kZRJu5R18K9do7vnLNlDHtjDLroA9hJ0Ml7r6tGbFFxW\n" +
            "SW2/MZZe8RuRSihwrE5bcUTzxcO70HJ2vQKCAQEAuPw1dkr1B9oo+DFNpc5OjOqO\n" +
            "xmTaKB03M7aGO+taxMTTH+l/82ujR2usKSbFMx1CqT7kV/jxEBXo6tGGuXryeC7t\n" +
            "9kClKs+3cQbieCV8312ZlYL4IRiVdKtOkc/4dccBz8eyqshp4qNnnr2qoQKQvhLh\n" +
            "3loT2p0OIuhsZ3ATePQdejxzGNlVnd9fi4U3+xJz0YScrGynCOFnqjUxpCYujSJ4\n" +
            "nqmwyHkigyLT+yA+UMQYMRCB1UiKU7HgY9jH6uILYxf28eLa/+7lIXBk11yaK0+H\n" +
            "f/xN0CpXfwiohqgTFKFupQJWfyBT5y+xFCKBVyMAFejK2opJVusx4r96wS43eA==\n" +
            "-----END RSA PRIVATE KEY-----".trimIndent())
    password.set("plugin")
  }

//  publishPlugin {
//    token.set(System.getenv("PUBLISH_TOKEN"))
//  }
}



