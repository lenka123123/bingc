//package bcms.monite.cn.bingchen.utils;
//
///**
// * @author: Liujunyong .
// * date:  2019/5/29.
// * <p>
// * <p>
// * RSA  公钥  rsaPublicKey
// * AES  密实  aesKey
// * <p>
// * 加密前 json
// * aesKey 对json进行加密   加密后encruyptData
// * <p>
// * rsaPublicKey对 aesKey进行加密  encryptAesKey
// * <p>
// * encryptAesKey 为请求头 将encruyptData 传输出去
// */
//public class RSAUtils {
//
//    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVZIPpL0+AkYw+jUhgfVi1LqrKvJ16mo4TU8IZzOewyMBTWrCBHdSPLRvpXeSCuN5tW77PTqxP5AC+CVxkYNkddu5DUiAK9mdekjojBgJqxzq2kxx99jXhHaskJzqqlGhJatXq5RoQL7yaO/01xizvoxOMR2EL3Yh5Snp7y2OdlwIDAQAB";
//
//
//    private static final String aaPrivateKey = "MIICWgIBAAKBgFvx7NMzaylASjFXMvbVaJFlmA614gYgqK7GJMjGVjbGFInXHsapQjTVErfPAHrVzmTtfqzkF/qa3k2bI706hsRvu1M0nYYjDkmZc0xOwT3Qn8jKaqrRRHr8BsCa2J+nYr2W8ITA0cSED4vZGHvovI5yDR0ImGNnkGNPEuuzpiGnAgMBAAECgYBEfCOpgOAt/rwEmm3Um0rjGegz9NghNkxOujoF7m2jKNF9hmVfFg3BaoAhtyclV4H/fULgppkRyi8RYSAyv5hHbOFe/5RAuNfZXMBn5PgIOiMQ/ZXj8UeZVQss5pNphO221zP9nEqOBK40tJwWkimALk/QsMPSCiklidfo2S5ByQJBAKwB51gWBISYMoVl1Ge8EabiH/dIOnz+lsSHfSttKsUkvV1sa6k1DkjSiX6+qH9r3jgDdb8klx0y78+/fv1FL0CQQCI160ge8dMowsKGUBBEvu42hC+OhAD0HhsXPs0mdWKNZfOjNLphVxpt1b4spQF+8VojePQsl44QphsBHoBzwAzAkBuXnpXZylW+2HPgo4B7X43kC0x/m3UMJ0AOsvF6H/5FqaFohN1AIa8cwxs+nI/50vkv7+hp0cy1C64dG78cPHxAkBp74WQYyJ7urC+JaQvfHGwveg+S5bATTAcu7KhGwJMF4cpGK3iqCJNmOhUaXLcWveNJGMb2inEphF3ddO5+LUvAkBaoevEzXvxNgw64Yamfe5HdWMir4UKsm8c5la5Hrl/zyBcICQZszTcjNGCW5Pe791RzWNT5Qw235C4f5EKDdi3";
//    private static final String aapublicKey = "MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgFvx7NMzaylASjFXMvbVaJFlmA614gYgqK7GJMjGVjbGFInXHsapQjTVErfPAHrVzmTtfqzkF/qa3k2bI706hsRvu1M0nYYjDkmZc0xOwT3Qn8jKaqrRRHr8BsCa2J+nYr2W8ITA0cSED4vZGHvovI5yDR0ImGNnkGNPEuuzpiGnAgMBAAE=";
//
//
//}
