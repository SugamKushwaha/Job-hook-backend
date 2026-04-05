package com.jobportal.JobPortal.utility;

public class Data {

    public static String getMessageBody(String otp){
       return  """
       <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>OTP Verification</title>
</head>

<body style="margin:0; padding:0; background-color:#f4f6f8; font-family:Arial, sans-serif;">

<table width="100%%" cellpadding="0" cellspacing="0" style="padding:20px;">
<tr>
<td align="center">

    <table width="500" cellpadding="0" cellspacing="0" 
           style="background:#ffffff; border-radius:10px; padding:30px; box-shadow:0 4px 10px rgba(0,0,0,0.1);">

        <!-- Header -->
        <tr>
            <td align="center">
                <h2 style="margin:0; color:#2c3e50;">Job Portal</h2>
                <p style="color:#888;">Secure Verification</p>
            </td>
        </tr>

        <!-- Divider -->
        <tr>
            <td><hr style="border:none; border-top:1px solid #eee; margin:20px 0;"></td>
        </tr>

        <!-- Content -->
        <tr>
            <td align="center">
                <h3 style="color:#333;">Your One-Time Password (OTP)</h3>
                <p style="color:#555;">Use the code below to complete your verification:</p>

                <div style="
                    font-size:32px;
                    font-weight:bold;
                    letter-spacing:8px;
                    color:#007bff;
                    margin:20px 0;
                ">
                    %s
                </div>

                <p style="color:#555;">⏳ This OTP is valid for <b>5 minutes</b>.</p>
                <p style="color:#e74c3c;"><b>Do not share this code with anyone.</b></p>
            </td>
        </tr>

        <!-- Footer -->
        <tr>
            <td>
                <hr style="border:none; border-top:1px solid #eee; margin:20px 0;">
                <p style="font-size:12px; color:#999; text-align:center;">
                    If you did not request this, please ignore this email.<br><br>
                    © 2026 Job Portal. All rights reserved.
                </p>
            </td>
        </tr>

    </table>

</td>
</tr>
</table>

</body>
</html>
""".formatted(otp);
    }
    
}
