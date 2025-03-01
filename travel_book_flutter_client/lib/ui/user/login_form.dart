import 'package:flutter/material.dart';

class LoginForm extends StatefulWidget {
  const LoginForm({super.key});

  @override
  State<LoginForm> createState() => _LoginFormState();
}

class _LoginFormState extends State<LoginForm> {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Form(
        key: _formKey,
        child: Column(
          children: <Widget>[
            TextFormField(
              validator: (value) {
                if (value == null || value.trim().isEmpty) {
                  return "Username cannot be empty";
                }
                return null;
              },
            ),
            TextFormField(
              obscureText: true,
              validator: (value) {
                if (value == null) {
                  return "Password cannot be empty";
                }
                return null;
              },
            ),
            ElevatedButton(
                onPressed: () {
                  final c = _formKey.currentState;
                  if (c != null && c.validate()) {
                    // TODO: call login
                  }
                },
                child: const Text("Login"))
          ],
        ));
  }
}
